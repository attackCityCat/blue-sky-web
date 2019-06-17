package org.bs.web.controller.dyl;


import org.bs.web.dao.MovieRepository;
import org.bs.web.pojo.MovieBean;
import org.bs.web.service.dyl.AboutService;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("dyl")
public class AboutController {

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private AboutService aboutService;

    @RequestMapping("queryMovieByName")
    public MovieBean queryMovieBynMame(String name){
        return aboutService.queryMovieByName(name);
    }

    @RequestMapping("queryMovie")
    public List<MovieBean> queryMMovie(){
        return aboutService.queryMovie();
    }



    //es搜索
    @RequestMapping("queryMovieList")
    public Map<String,Object> find(Integer page, Integer rows, MovieBean movieBean){
        //可以对 name  进行 模糊匹配  并且 高亮
        //对类型  型号  颜色  价格区间进行过滤
        //对价格进行排序  desc
        //分页

        //处理参数
        if (page == null)
            page = 1;
        if (rows == null)
            rows = 50;


        //创建 返回体
        HashMap<String, Object> result = new HashMap<>();

        //获取 查询组件
        /**
         * must  必须  and   should 应该  or  not_must 必须不  not
         */
        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
        if (movieBean.getName() != null && !"".equals(movieBean.getName()))
            boolQueryBuilder.should(QueryBuilders.matchQuery("name",movieBean.getName()));

        if (movieBean.getStatus() != null && movieBean.getStatus() != -1)
            boolQueryBuilder.filter(QueryBuilders.termQuery("status",movieBean.getStatus()));

        if (movieBean.getDerector() !=null && !"".equals(movieBean.getDerector()))
            boolQueryBuilder.filter(QueryBuilders.termQuery("derector",movieBean.getDerector()));

        if (movieBean.getLanguage() != null && movieBean.getLanguage() != -1)
            boolQueryBuilder.filter(QueryBuilders.termQuery("language",movieBean.getLanguage()));


        if (movieBean.getMinPrice() != null && movieBean.getMaxPrice() != null){
            boolQueryBuilder.filter(QueryBuilders.rangeQuery("price").from(movieBean.getMinPrice()).to(movieBean.getMaxPrice()));
        }else {
            if (movieBean.getMinPrice() != null){
                boolQueryBuilder.filter(QueryBuilders.rangeQuery("price").gte(movieBean.getMinPrice()));
            }
            if (movieBean.getMaxPrice() != null)
                boolQueryBuilder.filter(QueryBuilders.rangeQuery("price").lte(movieBean.getMaxPrice()));
        }

        if (movieBean.getMinLength() != null && movieBean.getMaxLength() != null){
            boolQueryBuilder.filter(QueryBuilders.rangeQuery("length").from(movieBean.getMinLength()).to(movieBean.getMaxLength()));
        }else {
            if (movieBean.getMinLength() != null){
                boolQueryBuilder.filter(QueryBuilders.rangeQuery("length").gte(movieBean.getMinLength()));
            }
            if (movieBean.getMaxLength() != null)
                boolQueryBuilder.filter(QueryBuilders.rangeQuery("length").lte(movieBean.getMaxLength()));
        }

        //获取高亮的组件
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.field("name");
        highlightBuilder.preTags("<span style='color:red;'>");
        highlightBuilder.postTags("</span>");

        //通过模板  获取搜索请求组件
        SearchRequestBuilder productindex = elasticsearchTemplate.getClient().prepareSearch("movie")
                .setExplain(true)  //设置是否对相关度进行排序   这里设置的是 是
                .highlighter(highlightBuilder)  // 设置高亮策略
                .setQuery(boolQueryBuilder) //设置查询策略
                .setTypes("movie")    //设置 索引中的类名
                .addSort("length", SortOrder.DESC) //设置 排序 策略  这里是对  商品价格  进行  逆序排序
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH) //设置查询的类型  有四种
                .setFrom((page - 1)*rows) //设置分页其实位置
                .setSize(rows);//设置每页条数

        //获取响应体
        SearchResponse searchResponse = productindex.get();

        SearchHits hits = searchResponse.getHits();

        //获取总条数
        int totalHits = (int) hits.totalHits;

        //获取数据存放的组件
        SearchHit[] hitsHits = hits.getHits();

        ArrayList<MovieBean> productBeans = new ArrayList<>();

        for (SearchHit searchHit : hitsHits){
            //创建一个实体
            MovieBean product = new MovieBean();

            Map<String, HighlightField> highlightFields = searchHit.getHighlightFields();

            HighlightField title = highlightFields.get("name");


            //处理高亮字段
            if (title == null)//如果高亮字段是空  那么 就用查找出的 普通的 字段
                product.setName(searchHit.getSourceAsMap().get("name").toString());
            else //如果 不是空那么 就用 高亮字段  替换掉  普通的字段
                product.setName(title.fragments()[0].toString());

            product.setId((Integer) searchHit.getSourceAsMap().get("id"));
            product.setDerector((String) searchHit.getSourceAsMap().get("derector"));
            product.setDetail((String) searchHit.getSourceAsMap().get("detail"));
            product.setLanguage((Integer) searchHit.getSourceAsMap().get("language"));
            product.setLength((Integer) searchHit.getSourceAsMap().get("length"));
            product.setPrice((Double) searchHit.getSourceAsMap().get("price"));
            product.setStatus((Integer) searchHit.getSourceAsMap().get("status"));
            //product.setFirstTime((Date) searchHit.getSourceAsMap().get("firstTime"));

            productBeans.add(product);
        }

        result.put("total",totalHits);
        result.put("rows",productBeans);
        return result;
    }

    @RequestMapping("saveMovie")
    public Boolean saveMovie(MovieBean movieBean){
        try {
            //先对数据库进行新增操作，如果数据库新增成功，那么在对索引进行新增
            movieRepository.save(movieBean);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }


}
