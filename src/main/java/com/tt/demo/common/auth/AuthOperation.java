package com.tt.demo.common.auth;

import com.tt.demo.common.Operation;
import com.tt.demo.common.OperationResult;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

/**
 * @author hansiyuan
 * @date 2021年06月19日 17:02
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Slf4j
public class AuthOperation  extends Operation {
    private final String userName;
    private final String password;

    @Override
    public AuthOperationResult execute() {
        if ("admin".equalsIgnoreCase(this.userName)) {
            AuthOperationResult orderResponse = new AuthOperationResult(true);
            return orderResponse;
        }

        return new AuthOperationResult(false);
    }
}
