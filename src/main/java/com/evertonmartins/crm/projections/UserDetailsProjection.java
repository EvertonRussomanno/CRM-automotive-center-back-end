package com.evertonmartins.crm.projections;

import java.util.UUID;

public interface UserDetailsProjection {

    String getUsername();
    String getPassword();
    Long getRoleId();
    String getAuthority();

}
