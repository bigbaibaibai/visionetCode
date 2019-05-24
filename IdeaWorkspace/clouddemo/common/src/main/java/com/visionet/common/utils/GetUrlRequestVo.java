package com.visionet.common.utils;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
//获取报价url需要发出请求json的类
public class GetUrlRequestVo {

    //订单，报价
    public static String ORDER_TYPE = "01";

    //承保
    public static String UNDERWRITE_TYPE = "02";

    //核保
    public static String UNDERWRITING_TYPE = "08";

    //请求类型
    private String operationType;

    //固定键
    private Token token;

    public GetUrlRequestVo(String operationType, Token token) {
        this.operationType = operationType;
        this.token = token;
    }


    @NoArgsConstructor
    @Data
    public static class Token {

        //中介云
        private String businessCode;
        //密码
        private String userPassword;
        //机构代码
        private String emarketCode;
        //价格折扣率（没有折扣传1）
        private String depositRate;
        //用户名
        private String userName;
        //用户代码
        private String userCode;

        //密钥
        private String token;
        //中介云产品代码
        private List<String> productCode;
        //渠道订单号
        private String thirdOrderNo;
        //订单操作类型(1:表示报价和录单)
        private String operate;

        public Token(String businessCode, String userPassword, String emarketCode, String depositRate, String userName, String userCode, String token, List<String> productCode, String thirdOrderNo, String operate) {
            this.businessCode = businessCode;
            this.userPassword = userPassword;
            this.emarketCode = emarketCode;
            this.depositRate = depositRate;
            this.userName = userName;
            this.userCode = userCode;
            this.token = token;
            this.productCode = productCode;
            this.thirdOrderNo = thirdOrderNo;
            this.operate = operate;
        }
    }

}
