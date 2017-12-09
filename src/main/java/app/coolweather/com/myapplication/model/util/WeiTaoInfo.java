package app.coolweather.com.myapplication.model.util;

import java.util.List;

/**
 * Created by Administrator on 2017/12/5.
 */

public class WeiTaoInfo {

    /**
     * code : 200
     * msg : 请求成功
     * result : {"brand_data":false,"catalog_data":false,"is_recommended":"1","page_data":[{"brand_id":"258","brief":"","channel_id":"3","cover_price":"168.00","figure":"/1476170715116.jpg","name":"【宅漫周边店】柴犬doge周边 可爱萌 牛角扣学院风呢子大衣 动漫外套","origin_price":"168.00","p_catalog_id":"65","product_id":"2855"},{"brand_id":"5","brief":"","channel_id":"3","cover_price":"299.00","figure":"/1469173640233.jpg","name":"Censi 声氏 Moecen猫耳耳机 尚硅谷 动漫 卖萌 头戴式 蓝牙耳机【白色版】","origin_price":"439.00","p_catalog_id":"101","product_id":"8262"},{"brand_id":"90","brief":"","channel_id":"3","cover_price":"199.00","figure":"/1447232577216.jpg","name":"【漫踪】原创 宫崎骏 龙猫 可爱雪地靴动漫保暖鞋周边冬季毛绒鞋子","origin_price":"318.00","p_catalog_id":"74","product_id":"2691"},{"brand_id":"77","brief":"本宝宝由漫T周边店提供，下单后7个工作日内发货~此款产品不支持7天无理由退换！小主们请明鉴噢♪(^∇^*)","channel_id":"3","cover_price":"114.00","figure":"/1474974516830.jpg","name":"【宅漫周边店】可爱猫咪后院周边 PU皮单肩包 大包 挎包 动漫周边","origin_price":"114.00","p_catalog_id":"82","product_id":"2889"},{"brand_id":"254","brief":"深蓝色预售期至7月22日~ 米色现货哦~~","channel_id":"8","cover_price":"99.00","figure":"/1465716158434.jpg","name":"【漫踪】猫咪后院T恤短袖 猫咪老师衣服闺蜜上衣动漫t","origin_price":"159.00","p_catalog_id":"56","product_id":"6979"},{"brand_id":"3","brief":"","channel_id":"4","cover_price":"22.00","figure":"/1450427011059.jpg","name":"【狐狸de动漫小屋】全门派职业·成男·金属书签 剑三","origin_price":"22.00","p_catalog_id":"26","product_id":"3563"},{"brand_id":"9","brief":"","channel_id":"3","cover_price":"59.00","figure":"/1462528256303.jpg","name":"【歪瓜出品】 魔卡少女樱百变小樱魔法阵pvc小夜灯led3d台灯动漫周边","origin_price":"118.00","p_catalog_id":"90","product_id":"6291"},{"brand_id":"5","brief":"","channel_id":"8","cover_price":"39.00","figure":"/1467796809278.jpg","name":"【漫境天空】恶搞表情包动漫T恤夏季短袖 沉迷学习日渐消瘦","origin_price":"39.00","p_catalog_id":"56","product_id":"7826"},{"brand_id":"34","brief":"","channel_id":"3","cover_price":"118.30","figure":"/1451294929366.jpg","name":"【漫踪】银魂正版帆布鞋女动漫板鞋","origin_price":"169.00","p_catalog_id":"74","product_id":"3760"},{"brand_id":"77","brief":"本商品由漫T周边店提供，7个工作日内发货","channel_id":"3","cover_price":"77.00","figure":"/1472198398679.jpg","name":"【宅漫周边店】猫咪后院 动漫周边 格子百褶/高腰/短裙 伞裙","origin_price":"77.00","p_catalog_id":"88","product_id":"2858"},{"brand_id":"3","brief":"","channel_id":"6","cover_price":"148.00","figure":"/supplier/1464589918004.jpg","name":"【逸影阁】剑网3 剑三 夜幕星河伞 直骨长柄/折叠雨伞 夏日出行","origin_price":"148.00","p_catalog_id":"17","product_id":"1910"},{"brand_id":"435","brief":"","channel_id":"6","cover_price":"29.00","figure":"/1469177978876.jpg","name":"【现货】【溪月兰心】原创印花发带 星河·白鹿 花青色","origin_price":"29.00","p_catalog_id":"71","product_id":"8278"},{"brand_id":"3","brief":"","channel_id":"4","cover_price":"115.00","figure":"/supplier/1464669637362.jpg","name":"【逸影阁】剑网3剑网三夜幕星河伞双层纸伞油纸伞刺绣纱幔","origin_price":"115.00","p_catalog_id":"17","product_id":"6730"},{"brand_id":"435","brief":"","channel_id":"6","cover_price":"29.00","figure":"/1469177815658.jpg","name":"【现货】【溪月兰心】原创印花发带 星河·白鹿 抹茶色 ","origin_price":"29.00","p_catalog_id":"71","product_id":"8277"}]}
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

    public static class ResultBean {
        /**
         * brand_data : false
         * catalog_data : false
         * is_recommended : 1
         * page_data : [{"brand_id":"258","brief":"","channel_id":"3","cover_price":"168.00","figure":"/1476170715116.jpg","name":"【宅漫周边店】柴犬doge周边 可爱萌 牛角扣学院风呢子大衣 动漫外套","origin_price":"168.00","p_catalog_id":"65","product_id":"2855"},{"brand_id":"5","brief":"","channel_id":"3","cover_price":"299.00","figure":"/1469173640233.jpg","name":"Censi 声氏 Moecen猫耳耳机 尚硅谷 动漫 卖萌 头戴式 蓝牙耳机【白色版】","origin_price":"439.00","p_catalog_id":"101","product_id":"8262"},{"brand_id":"90","brief":"","channel_id":"3","cover_price":"199.00","figure":"/1447232577216.jpg","name":"【漫踪】原创 宫崎骏 龙猫 可爱雪地靴动漫保暖鞋周边冬季毛绒鞋子","origin_price":"318.00","p_catalog_id":"74","product_id":"2691"},{"brand_id":"77","brief":"本宝宝由漫T周边店提供，下单后7个工作日内发货~此款产品不支持7天无理由退换！小主们请明鉴噢♪(^∇^*)","channel_id":"3","cover_price":"114.00","figure":"/1474974516830.jpg","name":"【宅漫周边店】可爱猫咪后院周边 PU皮单肩包 大包 挎包 动漫周边","origin_price":"114.00","p_catalog_id":"82","product_id":"2889"},{"brand_id":"254","brief":"深蓝色预售期至7月22日~ 米色现货哦~~","channel_id":"8","cover_price":"99.00","figure":"/1465716158434.jpg","name":"【漫踪】猫咪后院T恤短袖 猫咪老师衣服闺蜜上衣动漫t","origin_price":"159.00","p_catalog_id":"56","product_id":"6979"},{"brand_id":"3","brief":"","channel_id":"4","cover_price":"22.00","figure":"/1450427011059.jpg","name":"【狐狸de动漫小屋】全门派职业·成男·金属书签 剑三","origin_price":"22.00","p_catalog_id":"26","product_id":"3563"},{"brand_id":"9","brief":"","channel_id":"3","cover_price":"59.00","figure":"/1462528256303.jpg","name":"【歪瓜出品】 魔卡少女樱百变小樱魔法阵pvc小夜灯led3d台灯动漫周边","origin_price":"118.00","p_catalog_id":"90","product_id":"6291"},{"brand_id":"5","brief":"","channel_id":"8","cover_price":"39.00","figure":"/1467796809278.jpg","name":"【漫境天空】恶搞表情包动漫T恤夏季短袖 沉迷学习日渐消瘦","origin_price":"39.00","p_catalog_id":"56","product_id":"7826"},{"brand_id":"34","brief":"","channel_id":"3","cover_price":"118.30","figure":"/1451294929366.jpg","name":"【漫踪】银魂正版帆布鞋女动漫板鞋","origin_price":"169.00","p_catalog_id":"74","product_id":"3760"},{"brand_id":"77","brief":"本商品由漫T周边店提供，7个工作日内发货","channel_id":"3","cover_price":"77.00","figure":"/1472198398679.jpg","name":"【宅漫周边店】猫咪后院 动漫周边 格子百褶/高腰/短裙 伞裙","origin_price":"77.00","p_catalog_id":"88","product_id":"2858"},{"brand_id":"3","brief":"","channel_id":"6","cover_price":"148.00","figure":"/supplier/1464589918004.jpg","name":"【逸影阁】剑网3 剑三 夜幕星河伞 直骨长柄/折叠雨伞 夏日出行","origin_price":"148.00","p_catalog_id":"17","product_id":"1910"},{"brand_id":"435","brief":"","channel_id":"6","cover_price":"29.00","figure":"/1469177978876.jpg","name":"【现货】【溪月兰心】原创印花发带 星河·白鹿 花青色","origin_price":"29.00","p_catalog_id":"71","product_id":"8278"},{"brand_id":"3","brief":"","channel_id":"4","cover_price":"115.00","figure":"/supplier/1464669637362.jpg","name":"【逸影阁】剑网3剑网三夜幕星河伞双层纸伞油纸伞刺绣纱幔","origin_price":"115.00","p_catalog_id":"17","product_id":"6730"},{"brand_id":"435","brief":"","channel_id":"6","cover_price":"29.00","figure":"/1469177815658.jpg","name":"【现货】【溪月兰心】原创印花发带 星河·白鹿 抹茶色 ","origin_price":"29.00","p_catalog_id":"71","product_id":"8277"}]
         */

        private boolean brand_data;
        private boolean catalog_data;
        private String is_recommended;
        private List<PageDataBean> page_data;

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

        public List<PageDataBean> getPage_data() {
            return page_data;
        }

        public void setPage_data(List<PageDataBean> page_data) {
            this.page_data = page_data;
        }

        public static class PageDataBean {
            /**
             * brand_id : 258
             * brief :
             * channel_id : 3
             * cover_price : 168.00
             * figure : /1476170715116.jpg
             * name : 【宅漫周边店】柴犬doge周边 可爱萌 牛角扣学院风呢子大衣 动漫外套
             * origin_price : 168.00
             * p_catalog_id : 65
             * product_id : 2855
             */

            private String brand_id;
            private String brief;
            private String channel_id;
            private String cover_price;
            private String figure;
            private String name;
            private String origin_price;
            private String p_catalog_id;
            private String product_id;

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
