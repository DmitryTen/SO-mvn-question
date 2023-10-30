/*
 */

package org.example.vault.config;


//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Profile;
import org.springframework.vault.authentication.AppRoleAuthentication;
import org.springframework.vault.authentication.AppRoleAuthenticationOptions;
import org.springframework.vault.authentication.ClientAuthentication;
import org.springframework.vault.client.VaultEndpoint;
import org.springframework.vault.config.AbstractVaultConfiguration;

/**
 *
 * @author bahlef
 */
//@Configuration
//@Profile("standalone")
//@ConditionalOnProperty(value = "ccom.vault.enabled", havingValue = "true", matchIfMissing = true)
public class StandaloneVaultConfig extends AbstractVaultConfiguration {
//	@Value("${ccom.vault.roleId:}")
	private String roleId;
//
//	@Value("${ccom.vault.secretId:}")
	private String secretId;
//
//	@Value("${ccom.vault.uri:}")
	private String uri;
//
//	@Value("${ccom.vault.name}")
	private String vaultName;
//
//	@Value("${ccom.vault.enabled:true}")
	private boolean vaultEnabled;

	public VaultEndpoint vaultEndpoint() {

		throw new IllegalStateException("Vault URI (ccom.vault.uri) is null");
	}

	public ClientAuthentication clientAuthentication() {
		if (!vaultEnabled) {
			return null;
		}


		AppRoleAuthenticationOptions.AppRoleAuthenticationOptionsBuilder builder = AppRoleAuthenticationOptions.builder()
				.roleId(AppRoleAuthenticationOptions.RoleId.provided(roleId)).path(AppRoleAuthenticationOptions.DEFAULT_APPROLE_AUTHENTICATION_PATH);

			builder = builder.secretId(AppRoleAuthenticationOptions.SecretId.provided(secretId));

		return new AppRoleAuthentication(builder.build(), restOperations());
	}
}
