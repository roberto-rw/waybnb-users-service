package com.waybnb.users.keycloack;

import org.jboss.resteasy.client.jaxrs.internal.ResteasyClientBuilderImpl;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.admin.client.resource.UsersResource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class KeycloakProvider {
    @Value("${keycloak.server-url}")
    private String serverUrl;

    @Value("${keycloak.realm-name}")
    private String realmName;

    @Value("${keycloak.realm-master}")
    private String realmMaster;

    @Value("${keycloak.client-id}")
    private String clientId;

    @Value("${keycloak.username}")
    private String username;

    @Value("${keycloak.password}")
    private static String password;

    @Value("${keycloak.client-secret}")
    private static String clientSecret;

    public RealmResource getRealmResource() {
       Keycloak keycloack = KeycloakBuilder.builder()
           .serverUrl(serverUrl)
           .realm(realmMaster)
           .clientId(clientId)
           .username(username)
           .password(password)
               .clientSecret(clientSecret)
               .resteasyClient(new ResteasyClientBuilderImpl().
                       connectionPoolSize(10).
                       build())
           .build();
         return keycloack.realm(realmName);
    }

    public UsersResource getUserResource() {
        return getRealmResource().users();
    }
}
