package com.goudscode.security;

import com.google.common.collect.Sets;

import java.util.HashSet;
import java.util.Set;

import static com.goudscode.security.ApplicationUserPermissions.*;

public enum ApplicationUserRoles {

    ADMIN(Sets.newHashSet(COURSE_READ,COURSE_WRITE,STUDENT_READ,STUDENT_WRITE)),
    STUDENT(Sets.newHashSet());

    private final Set<ApplicationUserPermissions> permissions;

    ApplicationUserRoles(Set<ApplicationUserPermissions> permissions) {
        this.permissions = permissions;
    }
}
