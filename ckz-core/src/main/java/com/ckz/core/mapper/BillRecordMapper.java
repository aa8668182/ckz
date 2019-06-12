package com.ckz.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ckz.core.entity.BillRecord;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户账单记录表
 * 
 * @author ckz
 * @email 不告诉你
 * @date 2019-02-18 16:32:19
 */
@Mapper
public interface BillRecordMapper extends BaseMapper<BillRecord> {
	
}
