package com.mdx.admin.api;

import com.github.pagehelper.PageInfo;
import com.mdx.admin.api.pojo.dto.AccessTokenDTO;
import com.mdx.admin.api.pojo.dto.AdminDTO;
import com.mdx.admin.api.pojo.dto.KeywordDTO;
import com.mdx.admin.api.req.AdminLoginReq;
import com.mdx.admin.api.req.KeywordCreateReq;
import com.mdx.admin.api.req.KeywordDeleteReq;
import com.mdx.common.ObjectResp;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@ApiIgnore
@RequestMapping("/v1/admin/keyword")
public interface KeywordApi {

    @ApiOperation(value = "关键词获取(10101)")
    @RequestMapping(method = RequestMethod.GET, value = "/get")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Authorization", required = true, dataType = "string", paramType = "header"),
            @ApiImplicitParam(name = "keywordId", value = "关键词", required = true, paramType = "query", dataType = "integer")
    })
    public ObjectResp<KeywordDTO> getKeyword(@RequestParam("keywordId") Integer keywordId);


    @ApiOperation(value = "关键词存储(10102)")
    @RequestMapping(method = RequestMethod.POST, value = "/create")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Authorization", required = true, dataType = "string", paramType = "header"),
    })
    public ObjectResp<KeywordDTO> createKeyword(@Valid @RequestBody KeywordCreateReq req);

    @ApiOperation(value = "关键词列表(10103)")
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Authorization", required = true, dataType = "string", paramType = "header"),
            @ApiImplicitParam(name = "pageNumber", value = "分页",defaultValue = "1", required = false, paramType = "query", dataType = "integer"),
            @ApiImplicitParam(name = "pageSize", value = "条数",defaultValue = "9999", required = false, paramType = "query", dataType = "integer")
    })
    public ObjectResp<PageInfo<KeywordDTO>> listKeyword(@RequestParam(value = "pageNumber" , required = false) int pageNumber , @RequestParam(value = "pageSize",defaultValue = "9999" , required = false) int pageSize);



    @ApiOperation(value = "关键词删除(10104)")
    @RequestMapping(method = RequestMethod.POST, value = "/delete")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Authorization", required = true, dataType = "string", paramType = "header")
    })
    public ObjectResp<Integer> deleteKeyword(@Valid @RequestBody KeywordDeleteReq req);

}
