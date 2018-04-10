package com.xw.api.book;

import com.googlecode.jsonrpc4j.JsonRpcParam;

public interface BookApiService {

    int add(@JsonRpcParam("sessionid")String sessionid, @JsonRpcParam("userId")int userId, @JsonRpcParam("type")int type,@JsonRpcParam("desc") String desc);
}
