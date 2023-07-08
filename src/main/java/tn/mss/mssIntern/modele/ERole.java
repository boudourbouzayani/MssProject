package tn.mss.mssIntern.modele;
import jakarta.persistence.*;

import java.io.Serializable;

public enum ERole {
    SIMPLE_USER("ROLE_SIMPLE_USER"),
    MANAGER("ROLE_MANAGER"),
    MEMBER("ROLE_MEMBER");
    private final String roleName;

    ERole(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }


}
