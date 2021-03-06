package com.cloud.cloud;

import javax.validation.GroupSequence;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public interface ValidationService {// 缺省可按服务接口区分验证场景，如：@NotNull(groups = ValidationService.class)
    @GroupSequence(Update.class)// 同时验证Update组规则
    @interface Save{}//与方法同名接口，首字母大写，用于区分验证场景，如：@NotNull(groups = ValidationService.Save.class)，可选
    void save(@NotNull ValidationParameter parameter);
    @interface Update{}
    void update(@NotNull ValidationParameter parameter);
    @interface Delete{}
    void delete(@Min(1) int id);
}
