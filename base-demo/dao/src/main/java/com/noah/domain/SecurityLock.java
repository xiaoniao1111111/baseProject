package com.noah.domain;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
/**
 * <p>
 * 
 * </p>
 *
 * @author wxw
 * @since 2020-10-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SecurityLock implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 分布式锁的名称
     */
    private String lockName;

}
