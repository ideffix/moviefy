package com.moviefy.backend.filters;

import com.moviefy.backend.user.Roles;
import org.springframework.stereotype.Component;

@Component
public class CheckUserRoleFilter extends BaseRoleFilter {

    public CheckUserRoleFilter(CurrentUserHolder currentUserHolder) {
        super(Roles.USER, currentUserHolder);
    }
}
