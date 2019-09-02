package com.anzhi.solidwaste.test.entity;

import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 
 *
 * @author Anzhi
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TTest implements Serializable {

    private static final long serialVersionUID = 1L;

        @TableField("FIELD1")
    private String field1;

        @TableField("FIELD2")
    private Integer field2;

        @TableField("FIELD3")
    private String field3;

        @TableField("CREATE_TIME")
    private LocalDateTime createTime;


}
