package com.yangnk.pojo;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

/**
 * ${DESCRIPTION}
 *
 * @author yangningkai
 * @create 2019-04-24 上午10:57
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private String id;
    @NotNull
    @Length(max = 20)
    private String userName;
    @NotNull
    @Pattern(regexp = "[A-Z][a-z][0-9]")
    private String passWord;
    @DateTimeFormat(pattern = "yyy-MM-dd")
    private Date createTime;
    private String alias;
    @Max(10)
    @Min(1)
    private Integer level;
    private Integer vip;
}
