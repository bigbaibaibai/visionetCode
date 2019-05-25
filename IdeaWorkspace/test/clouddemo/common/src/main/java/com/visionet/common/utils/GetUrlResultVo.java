package com.visionet.common.utils;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
public class GetUrlResultVo {

    private String code;
    private ResultData data;
    private boolean success;
    private String message;

    @Data
    @NoArgsConstructor
    static public class ResultData {
        private Map<String, String> obj;
        private List<String> list;

        public ResultData(Map<String, String> obj, List<String> list) {
            this.obj = obj;
            this.list = list;
        }
    }

    public GetUrlResultVo(String code, ResultData data, boolean success, String message) {
        this.code = code;
        this.data = data;
        this.success = success;
        this.message = message;
    }
}
