package com.ckz.core.common;


import com.baomidou.mybatisplus.extension.service.IService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ${DESCRIPTION}
 *
 * @author ckz
 * @create 2019-01-10 8:48
 */
@Slf4j
public class BaseController<Service extends IService, Entity> {
    @Autowired
    protected HttpServletRequest request;
    @Autowired
    protected HttpServletResponse response;
    @Autowired
    protected Service service;

    @Autowired
    protected RedisTemplate<String,Object> redisTemplate;

    /*@RequestMapping(value = "/addEntity")
    @ApiOperation(value = "新增实体对象")
    public ApiResponse add(@RequestBody @ApiParam(name="id",value="用户id",required=true) Entity entity){
        service.save(entity);
        return ResultUtils.setOk();
    }

    @RequestMapping(value = "/getEntityById")
    @ApiOperation(value = "查询实体根据ID")
    @ApiParam(value="主键ID",required=true)
    public ApiResponse getById(Long id){
        return ResultUtils.setOk(service.getById(id));
    }

    @RequestMapping(value = "updateEntityById")
    @ApiOperation(value = "修改实体根据ID")
    public ApiResponse updateEntityById(@ModelAttribute Entity entity){
        service.updateById(entity);
        return ResultUtils.setOk();
    }
    @RequestMapping(value = "removeEntityById")
    @ApiOperation(value = "删除实体根据ID")
    @ApiParam(value="主键ID",required=true)
    public ApiResponse removeById(Long id){
        service.removeById(id);
        return ResultUtils.setOk();
    }

    @RequestMapping(value = "/allEntity")
    @ApiOperation(value = "查询所有实体")
    public ApiResponse all(){
        return ResultUtils.setOk(service.list(new QueryWrapper<Entity>()));
    }

    @RequestMapping(value = "/updateBatch")
    @ApiOperation("根据ID批量更新")
    public ApiResponse updateBatch(List<Entity> entities){
        if(entities != null && entities.size() > 0)
            service.updateBatchById(entities,1000);
        return  ResultUtils.setOk();
    }



    @RequestMapping("/list")
    @ApiOperation("查询")
    public ApiResponse list(Map<String, Object> params){
        Page queryPage = createPage(params);
        Wrapper entityWrapper = createPageWrapper(params);
        if (queryPage == null) {
            return Optional.ofNullable(service.list(entityWrapper))
                    .map(allResult -> ResultUtils.setOk(allResult))
                    .orElseGet(() -> ResultUtils.setOk(Collections.EMPTY_LIST));
        } else {
            Map resultMap=new HashMap();

            return Optional.ofNullable(service.page(queryPage, entityWrapper))
                    .map(pageResult ->{
                                resultMap.put("currentPage",pageResult.getCurrent());
                                resultMap.put("pageSize",pageResult.getSize());
                                resultMap.put("pages", pageResult.getPages());
                                resultMap.put("total",pageResult.getTotal());
                                resultMap.put("list",pageResult.getRecords());
                                return  ResultUtils.setOk(resultMap);
                            })
                    .orElseGet(() -> ResultUtils.setError(MpExceptionCode.FAILED));
        }
    }

    *//**
     * 根据参数创建分页条件
     * *//*
    private Page createPage(Map<String, Object> params) {

        if (params.get("page") != null && params.get("limit") != null) {
            Page<Entity> queryPage = new Page<>();
            queryPage.setCurrent(Integer.parseInt(params.get("page").toString()));
            queryPage.setSize(Integer.parseInt(params.get("limit").toString()));
            queryPage.setDesc("create_time");
            return queryPage;
        } else {
            return null;
        }
    }

    *//**
     * 根据参数创建分页查询条件
     * *//*
    private Wrapper createPageWrapper(Map<String, Object> params) {
        QueryWrapper entityWrapper = new QueryWrapper<>();
        Class clazz = this.getGenericClass();
        Arrays.stream(clazz.getDeclaredFields())
                .filter(this::isTableFieldExist)
                .forEach(field -> this.appendWrapper(entityWrapper, field, params));
        return entityWrapper;
    }

    *//**
     * 获得本类泛型
     * *//*
    private Class getGenericClass() {
        Type superClass = this.getClass().getGenericSuperclass();
        Type type = ((ParameterizedType) superClass).getActualTypeArguments()[1];
        Class clazz = (Class) type;
        return clazz;
    }

    *//**
     * 过滤掉不是数据库column的字段且不是变换查询字段的
     * *//*
    private boolean isTableFieldExist(Field field){
        FieldConvert fieldConvertAnnotation = field.getAnnotation(FieldConvert.class);
        TableField tableFieldAnnotation = field.getAnnotation(TableField.class);
        return fieldConvertAnnotation != null
                || tableFieldAnnotation == null
                || tableFieldAnnotation.exist();
    }

    *//**
     * 对有@FieldConvert的查询字段做转换处理
     * *//*
    protected Wrapper hookConvertWrapper(Wrapper wrapper, Field field, Map<String, Object> params) {
        return wrapper;
    }

    *//**
     * 将参数追加到分页查询条件
     * *//*
    private Wrapper appendWrapper(AbstractWrapper wrapper, Field field, Map<String, Object> params){
        field.setAccessible(true); //设置些属性是可以访问的
        String name = field.getName();
        Class fieldClass = field.getType();

        if (field.getAnnotation(FieldConvert.class) != null){
            hookConvertWrapper(wrapper, field, params);
        } else if (Date.class == fieldClass) {
            Object begin = params.get(name + "Begin");
            Object end = params.get(name + "End");
            if(begin != null){
                wrapper.ge(CamelCaseToUnderscore.humpToLine2(name),begin);
            }
            if(end != null){
                try {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    Date endDate = simpleDateFormat.parse(end.toString());
                    //+1天
                    Date afterOneDate = new Date(endDate.getTime() + (86400 * 1000));
                    String  endTime= simpleDateFormat.format(afterOneDate);

                    wrapper.lt(CamelCaseToUnderscore.humpToLine2(name), endTime);

                }catch (Exception ex){
                    log.error(ex.getMessage());
                }
            }
        } else if (String.class == fieldClass) {
            String value = (String) params.get(name);
            if(StringUtils.isNotEmpty(value)){
                wrapper.like(CamelCaseToUnderscore.humpToLine2(name),value);
            }
        } else {
            Object value = params.get(name);
            if (value != null) {
                wrapper.eq(CamelCaseToUnderscore.humpToLine2(name),value);
            }
        }

        return wrapper;
    }*/


}