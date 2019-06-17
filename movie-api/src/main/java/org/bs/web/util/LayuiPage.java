    package org.bs.web.util;

    /**
      * 封装后端返回给LayUI的Json数据
     * @author EDZ
     *
     * @param <T>
     */
    public class LayuiPage<T> {

        private int code;       //一般不写默认为0
        private long count;     //分页显示条数
        private String msg;     // 提示
        private T data;         // 查询出来的数据




        /**
         *      * getter、setter方法
         *      * @return
         *     
         */
        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public long getCount() {
            return count;
        }

        public void setCount(long count) {
            this.count = count;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

    }
