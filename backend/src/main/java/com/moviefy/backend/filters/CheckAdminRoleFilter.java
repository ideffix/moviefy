package com.moviefy.backend.filters;

import com.moviefy.backend.user.Roles;
import org.springframework.stereotype.Component;


@Component
public class CheckAdminRoleFilter extends BaseRoleFilter {

    public CheckAdminRoleFilter(CurrentUserHolder currentUserHolder) {
        super(Roles.ADMIN, currentUserHolder);
    }
}
