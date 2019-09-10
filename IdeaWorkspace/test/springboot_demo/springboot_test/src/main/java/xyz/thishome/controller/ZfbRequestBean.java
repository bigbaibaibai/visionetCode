package xyz.thishome.controller;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Time: 2019/8/5 17:58
 * @Author: bxx
 * @Description:  支付宝请求JSON接收Bean
 */
@Data
public class ZfbRequestBean {
    private String gmt_create;
    private String charset;
    private String seller_email;
    private String subject;
    private String sign;
    private String body;
    private String buyer_id;
    private BigDecimal invoice_amount;
    private String notify_id;
    private String fund_bill_list;
    private String notify_type;
    private String trade_status;
    private BigDecimal receipt_amount;
    private BigDecimal buyer_pay_amount;
    private String app_id;
    private String sign_type;
    private String seller_id;
    private String gmt_payment;
    private String notify_time;
    private String version;
    private String out_trade_no;
    private BigDecimal total_amount;
    private String trade_no;
    private String auth_app_id;
    private String buyer_logon_id;
    private BigDecimal point_amount;
}
