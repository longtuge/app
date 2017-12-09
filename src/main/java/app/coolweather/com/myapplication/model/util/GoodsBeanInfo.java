package app.coolweather.com.myapplication.model.util;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/11/4.
 */

public class GoodsBeanInfo  {

    /**
     * code : 200
     * msg : 请求成功
     * result : {"brand_data":false,"catalog_data":false,"is_recommended":"0","page_data":[{"brand_id":"77","brief":"","channel_id":"3","cover_price":"25.00","figure":"/1442219020234.jpg","name":"【喵鹿酱】毛绒公仔 喵星人 萌萌哒  饼干猫咪抱枕","origin_price":"25.00","p_catalog_id":"22","product_id":"1365"},{"brand_id":"77","brief":"","channel_id":"12","cover_price":"25.00","figure":"/1461122800918.jpg","name":"【Honest首饰】925银戒指 线条 喵星人 概念猫耳戒指","origin_price":"29.00","p_catalog_id":"73","product_id":"6036"},{"brand_id":"77","brief":"","channel_id":"8","cover_price":"49.00","figure":"/1451107788981.jpg","name":"【漫踪】原创 EVA 明日香 喵星人 超萌猫耳帽 徽章帽 遮阳帽子","origin_price":"69.00","p_catalog_id":"70","product_id":"3722"},{"brand_id":"77","brief":"","channel_id":"3","cover_price":"48.00","figure":"/1458284283746.jpg","name":"[散漫舍]颜文字炸鸡块萌系猫咪喵星人单肩绒毛","origin_price":"68.00","p_catalog_id":"82","product_id":"3346"},{"brand_id":"77","brief":"ACG作品名: 颜文字出售状态: 现货动漫地区: 日本周边产品: 抱枕/靠垫品牌: 漫趣型号: 颜文字材质: 毛绒","channel_id":"3","cover_price":"59.00","figure":"/1435655316506.jpg","name":"【漫趣】颜文字 炸鸡块 抱枕 天使 喵星人 午睡枕","origin_price":"69.00","p_catalog_id":"22","product_id":"291"},{"brand_id":"254","brief":"预售期至11月22日，出货后将按订单顺序安排发货噢~","channel_id":"3","cover_price":"49.00","figure":"/1478684458165.jpg","name":"预售【漫踪】尚硅谷毛绒玩偶秋冬保暖喵星人猫咪后院暖手捂大抱枕","origin_price":"0.00","p_catalog_id":"22","product_id":"10577"},{"brand_id":"383","brief":"","channel_id":"8","cover_price":"31.20","figure":"/1478771479131.jpg","name":"【蜜茶联萌】原创喵星人流行梗 纯棉长袖T恤 日常创意打底 早睡醒了","origin_price":"39.00","p_catalog_id":"56","product_id":"10613"},{"brand_id":"383","brief":"","channel_id":"8","cover_price":"31.20","figure":"/1478770606292.jpg","name":"【蜜茶联萌】原创喵星人流行梗 纯棉长袖T恤 日常创意打底 上天","origin_price":"39.00","p_catalog_id":"56","product_id":"10606"},{"brand_id":"383","brief":"","channel_id":"8","cover_price":"31.20","figure":"/1478770259484.jpg","name":"【蜜茶联萌】原创喵星人流行梗 纯棉长袖T恤 日常创意打底 人生苦短","origin_price":"39.00","p_catalog_id":"56","product_id":"10605"},{"brand_id":"383","brief":"","channel_id":"8","cover_price":"31.20","figure":"/1478771356352.jpg","name":"【蜜茶联萌】原创喵星人流行梗 纯棉长袖T恤 日常创意打底 给机会多说","origin_price":"39.00","p_catalog_id":"56","product_id":"10612"},{"brand_id":"383","brief":"","channel_id":"8","cover_price":"31.20","figure":"/1478771175422.jpg","name":"【蜜茶联萌】原创喵星人流行梗 纯棉长袖T恤 日常创意打底 洪荒之力","origin_price":"39.00","p_catalog_id":"56","product_id":"10611"},{"brand_id":"383","brief":"","channel_id":"8","cover_price":"31.20","figure":"/1478771065211.jpg","name":"【蜜茶联萌】原创喵星人流行梗 纯棉长袖T恤 日常创意打底 嘿嘿嘿","origin_price":"39.00","p_catalog_id":"56","product_id":"10609"},{"brand_id":"383","brief":"","channel_id":"8","cover_price":"31.20","figure":"/1478770896479.jpg","name":"【蜜茶联萌】原创喵星人流行梗 纯棉长袖T恤 日常创意打底 上车了","origin_price":"39.00","p_catalog_id":"56","product_id":"10608"},{"brand_id":"383","brief":"","channel_id":"8","cover_price":"31.20","figure":"/1478770777024.jpg","name":"【蜜茶联萌】原创喵星人流行梗 纯棉长袖T恤 日常创意打底 静静看着","origin_price":"39.00","p_catalog_id":"56","product_id":"10607"},{"brand_id":"77","brief":"","channel_id":"12","cover_price":"19.00","figure":"/1461121730483.jpg","name":"【Honest】925银耳钉 喵星人 精灵猫","origin_price":"29.00","p_catalog_id":"73","product_id":"6033"},{"brand_id":"5","brief":"","channel_id":"12","cover_price":"28.00","figure":"/1467626635120.png","name":"【Honest首饰】 925银耳钉 白金版  可爱小猫咪 喵星人 简约","origin_price":"39.00","p_catalog_id":"73","product_id":"7725"},{"brand_id":"182","brief":"","channel_id":"3","cover_price":"20.00","figure":"/1437034378542.jpg","name":"【天闻角川】直供  喵星人 挂绳卡套02·西瓜","origin_price":"20.00","p_catalog_id":"37","product_id":"385"},{"brand_id":"77","brief":"","channel_id":"12","cover_price":"17.00","figure":"/1461122483808.jpg","name":"【Honest】925银耳钉 喵星人 卷尾猫","origin_price":"27.00","p_catalog_id":"73","product_id":"6035"},{"brand_id":"77","brief":"","channel_id":"5","cover_price":"25.00","figure":"/1435115327659.jpg","name":"【orz漫工厂】cosplay 百搭饰品 猫领结 铃铛 猫爪 喵星人手套","origin_price":"30.00","p_catalog_id":"20","product_id":"234"},{"brand_id":"77","brief":"","channel_id":"12","cover_price":"26.00","figure":"/1461123395992.jpg","name":"【Honest】925银戒指 Hello kitty 喵星人 开口可调节戒指","origin_price":"38.00","p_catalog_id":"73","product_id":"6039"}]}
     */

    private int code;
    private String msg;
    private ResultBean result;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean implements Serializable {
        /**
         * brand_data : false
         * catalog_data : false
         * is_recommended : 0
         * page_data : [{"brand_id":"77","brief":"","channel_id":"3","cover_price":"25.00","figure":"/1442219020234.jpg","name":"【喵鹿酱】毛绒公仔 喵星人 萌萌哒  饼干猫咪抱枕","origin_price":"25.00","p_catalog_id":"22","product_id":"1365"},{"brand_id":"77","brief":"","channel_id":"12","cover_price":"25.00","figure":"/1461122800918.jpg","name":"【Honest首饰】925银戒指 线条 喵星人 概念猫耳戒指","origin_price":"29.00","p_catalog_id":"73","product_id":"6036"},{"brand_id":"77","brief":"","channel_id":"8","cover_price":"49.00","figure":"/1451107788981.jpg","name":"【漫踪】原创 EVA 明日香 喵星人 超萌猫耳帽 徽章帽 遮阳帽子","origin_price":"69.00","p_catalog_id":"70","product_id":"3722"},{"brand_id":"77","brief":"","channel_id":"3","cover_price":"48.00","figure":"/1458284283746.jpg","name":"[散漫舍]颜文字炸鸡块萌系猫咪喵星人单肩绒毛","origin_price":"68.00","p_catalog_id":"82","product_id":"3346"},{"brand_id":"77","brief":"ACG作品名: 颜文字出售状态: 现货动漫地区: 日本周边产品: 抱枕/靠垫品牌: 漫趣型号: 颜文字材质: 毛绒","channel_id":"3","cover_price":"59.00","figure":"/1435655316506.jpg","name":"【漫趣】颜文字 炸鸡块 抱枕 天使 喵星人 午睡枕","origin_price":"69.00","p_catalog_id":"22","product_id":"291"},{"brand_id":"254","brief":"预售期至11月22日，出货后将按订单顺序安排发货噢~","channel_id":"3","cover_price":"49.00","figure":"/1478684458165.jpg","name":"预售【漫踪】尚硅谷毛绒玩偶秋冬保暖喵星人猫咪后院暖手捂大抱枕","origin_price":"0.00","p_catalog_id":"22","product_id":"10577"},{"brand_id":"383","brief":"","channel_id":"8","cover_price":"31.20","figure":"/1478771479131.jpg","name":"【蜜茶联萌】原创喵星人流行梗 纯棉长袖T恤 日常创意打底 早睡醒了","origin_price":"39.00","p_catalog_id":"56","product_id":"10613"},{"brand_id":"383","brief":"","channel_id":"8","cover_price":"31.20","figure":"/1478770606292.jpg","name":"【蜜茶联萌】原创喵星人流行梗 纯棉长袖T恤 日常创意打底 上天","origin_price":"39.00","p_catalog_id":"56","product_id":"10606"},{"brand_id":"383","brief":"","channel_id":"8","cover_price":"31.20","figure":"/1478770259484.jpg","name":"【蜜茶联萌】原创喵星人流行梗 纯棉长袖T恤 日常创意打底 人生苦短","origin_price":"39.00","p_catalog_id":"56","product_id":"10605"},{"brand_id":"383","brief":"","channel_id":"8","cover_price":"31.20","figure":"/1478771356352.jpg","name":"【蜜茶联萌】原创喵星人流行梗 纯棉长袖T恤 日常创意打底 给机会多说","origin_price":"39.00","p_catalog_id":"56","product_id":"10612"},{"brand_id":"383","brief":"","channel_id":"8","cover_price":"31.20","figure":"/1478771175422.jpg","name":"【蜜茶联萌】原创喵星人流行梗 纯棉长袖T恤 日常创意打底 洪荒之力","origin_price":"39.00","p_catalog_id":"56","product_id":"10611"},{"brand_id":"383","brief":"","channel_id":"8","cover_price":"31.20","figure":"/1478771065211.jpg","name":"【蜜茶联萌】原创喵星人流行梗 纯棉长袖T恤 日常创意打底 嘿嘿嘿","origin_price":"39.00","p_catalog_id":"56","product_id":"10609"},{"brand_id":"383","brief":"","channel_id":"8","cover_price":"31.20","figure":"/1478770896479.jpg","name":"【蜜茶联萌】原创喵星人流行梗 纯棉长袖T恤 日常创意打底 上车了","origin_price":"39.00","p_catalog_id":"56","product_id":"10608"},{"brand_id":"383","brief":"","channel_id":"8","cover_price":"31.20","figure":"/1478770777024.jpg","name":"【蜜茶联萌】原创喵星人流行梗 纯棉长袖T恤 日常创意打底 静静看着","origin_price":"39.00","p_catalog_id":"56","product_id":"10607"},{"brand_id":"77","brief":"","channel_id":"12","cover_price":"19.00","figure":"/1461121730483.jpg","name":"【Honest】925银耳钉 喵星人 精灵猫","origin_price":"29.00","p_catalog_id":"73","product_id":"6033"},{"brand_id":"5","brief":"","channel_id":"12","cover_price":"28.00","figure":"/1467626635120.png","name":"【Honest首饰】 925银耳钉 白金版  可爱小猫咪 喵星人 简约","origin_price":"39.00","p_catalog_id":"73","product_id":"7725"},{"brand_id":"182","brief":"","channel_id":"3","cover_price":"20.00","figure":"/1437034378542.jpg","name":"【天闻角川】直供  喵星人 挂绳卡套02·西瓜","origin_price":"20.00","p_catalog_id":"37","product_id":"385"},{"brand_id":"77","brief":"","channel_id":"12","cover_price":"17.00","figure":"/1461122483808.jpg","name":"【Honest】925银耳钉 喵星人 卷尾猫","origin_price":"27.00","p_catalog_id":"73","product_id":"6035"},{"brand_id":"77","brief":"","channel_id":"5","cover_price":"25.00","figure":"/1435115327659.jpg","name":"【orz漫工厂】cosplay 百搭饰品 猫领结 铃铛 猫爪 喵星人手套","origin_price":"30.00","p_catalog_id":"20","product_id":"234"},{"brand_id":"77","brief":"","channel_id":"12","cover_price":"26.00","figure":"/1461123395992.jpg","name":"【Honest】925银戒指 Hello kitty 喵星人 开口可调节戒指","origin_price":"38.00","p_catalog_id":"73","product_id":"6039"}]
         */

        private boolean brand_data;
        private boolean catalog_data;
        private String is_recommended;
        private List<GoodsBean> page_data;

        public boolean isBrand_data() {
            return brand_data;
        }

        public void setBrand_data(boolean brand_data) {
            this.brand_data = brand_data;
        }

        public boolean isCatalog_data() {
            return catalog_data;
        }

        public void setCatalog_data(boolean catalog_data) {
            this.catalog_data = catalog_data;
        }

        public String getIs_recommended() {
            return is_recommended;
        }

        public void setIs_recommended(String is_recommended) {
            this.is_recommended = is_recommended;
        }

        public List<GoodsBean> getPage_data() {
            return page_data;
        }

        public void setPage_data(List<GoodsBean> page_data) {
            this.page_data = page_data;
        }

        public static class GoodsBean implements Serializable {
            /**
             * brand_id : 77
             * brief :
             * channel_id : 3
             * cover_price : 25.00
             * figure : /1442219020234.jpg
             * name : 【喵鹿酱】毛绒公仔 喵星人 萌萌哒  饼干猫咪抱枕
             * origin_price : 25.00
             * p_catalog_id : 22
             * product_id : 1365
             */
            //
            private String brand_id;
            //商品数量
            private String brief;
            //型号
            private String channel_id;
            //价格
            private String cover_price;
            //商品图片
            private String figure;
            //商品名
            private String name;
            //原价
            private String origin_price;
            //
            private String p_catalog_id;
            //商品id
            private String product_id;
            //判断是否选中
            private boolean isCheck = false;

            public boolean isCheck() {
                return isCheck;
            }

            public void setCheck(boolean check) {
                isCheck = check;
            }

            public String getBrand_id() {
                return brand_id;
            }

            public void setBrand_id(String brand_id) {
                this.brand_id = brand_id;
            }

            public String getBrief() {
                return brief;
            }

            public void setBrief(String brief) {
                this.brief = brief;
            }

            public String getChannel_id() {
                return channel_id;
            }

            public void setChannel_id(String channel_id) {
                this.channel_id = channel_id;
            }

            public String getCover_price() {
                return cover_price;
            }

            public void setCover_price(String cover_price) {
                this.cover_price = cover_price;
            }

            public String getFigure() {
                return figure;
            }

            public void setFigure(String figure) {
                this.figure = figure;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getOrigin_price() {
                return origin_price;
            }

            public void setOrigin_price(String origin_price) {
                this.origin_price = origin_price;
            }

            public String getP_catalog_id() {
                return p_catalog_id;
            }

            public void setP_catalog_id(String p_catalog_id) {
                this.p_catalog_id = p_catalog_id;
            }

            public String getProduct_id() {
                return product_id;
            }

            public void setProduct_id(String product_id) {
                this.product_id = product_id;
            }
        }
    }
}


