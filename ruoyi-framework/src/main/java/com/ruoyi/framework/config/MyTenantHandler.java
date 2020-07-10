package com.ruoyi.framework.config;

import com.baomidou.mybatisplus.extension.plugins.tenant.TenantHandler;
import com.ruoyi.framework.util.ShiroUtils;
import com.ruoyi.system.domain.SysUser;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.LongValue;
import org.springframework.stereotype.Component;

/*
 *chenyou
 *多租户处理器
 */
@Slf4j
@Component
public class MyTenantHandler implements TenantHandler {

  /**
   * 租户标识
   */
  private static final String SYSTEM_TENANT_ID = "tenant_id";

  /**
   * 需要过滤的表
   */
  private static final List<String> IGNORE_TENANT_TABLES = new ArrayList<>();

  @Override
/**
 * 获取租户Id
 */
  public Expression getTenantId(boolean where) {
    SysUser user = ShiroUtils.getSysUser();
    // Long tenantId = user.getTenantId();
    return new LongValue(-1 + "");
  }

  /**
   * 租户字段名
   */
  @Override
  public String getTenantIdColumn() {
    return SYSTEM_TENANT_ID;
  }

  @Override
  public boolean doTableFilter(String tableName) {
    return IGNORE_TENANT_TABLES.stream().anyMatch((e) -> e.equalsIgnoreCase(tableName));
  }
}
