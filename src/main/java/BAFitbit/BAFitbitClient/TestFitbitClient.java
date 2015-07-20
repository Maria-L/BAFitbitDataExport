package BAFitbit.BAFitbitClient;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fitbit.api.client.FitbitAPIEntityCache;
import com.fitbit.api.client.FitbitApiClientAgent;
import com.fitbit.api.client.FitbitApiCredentialsCache;
import com.fitbit.api.client.FitbitApiSubscriptionStorage;
import com.fitbit.api.client.service.FitbitAPIClientService;

public class TestFitbitClient {

	protected Log log = LogFactory.getLog(getClass());

	private static final int APP_USER_COOKIE_TTL = 60 * 60 * 24 * 7 * 4;
	private static final String APP_USER_COOKIE_NAME = "exampleClientUid";

	public static final String OAUTH_TOKEN = "oauth_token";
	public static final String OAUTH_VERIFIER = "oauth_verifier";

	private static final String NOTIFICATION_UPDATES_SUBSCRIBER_ID = "1";

	@Resource
	private FitbitAPIEntityCache entityCache;
	@Resource
	private FitbitApiCredentialsCache credentialsCache;
	@Resource
	private FitbitApiSubscriptionStorage subscriptionStore;

	private String fitbitSiteBaseUrl = "https://www.fitbit.com";
	public Log getLog() {
		return log;
	}


	private String apiBaseUrl = "api.fitbit.com";
	private String exampleBaseUrl = "http://your.application.host/path/";

	private String clientConsumerKey = "";
	private String clientSecret = "";
	
	
	
	 public FitbitAPIClientService<FitbitApiClientAgent> initalize(){
		 FitbitAPIClientService<FitbitApiClientAgent> apiClientService = new FitbitAPIClientService<FitbitApiClientAgent>(
	             new FitbitApiClientAgent(getApiBaseUrl(), getFitbitSiteBaseUrl(), credentialsCache),
	             clientConsumerKey,
	             clientSecret,
	             credentialsCache,
	             entityCache,
	             subscriptionStore
	     );
		return apiClientService;		 
	 }

	public void setLog(Log log) {
		this.log = log;
	}



	public FitbitAPIEntityCache getEntityCache() {
		return entityCache;
	}



	public void setEntityCache(FitbitAPIEntityCache entityCache) {
		this.entityCache = entityCache;
	}



	public FitbitApiCredentialsCache getCredentialsCache() {
		return credentialsCache;
	}



	public void setCredentialsCache(FitbitApiCredentialsCache credentialsCache) {
		this.credentialsCache = credentialsCache;
	}



	public FitbitApiSubscriptionStorage getSubscriptionStore() {
		return subscriptionStore;
	}



	public void setSubscriptionStore(FitbitApiSubscriptionStorage subscriptionStore) {
		this.subscriptionStore = subscriptionStore;
	}



	public String getFitbitSiteBaseUrl() {
		return fitbitSiteBaseUrl;
	}



	public void setFitbitSiteBaseUrl(String fitbitSiteBaseUrl) {
		this.fitbitSiteBaseUrl = fitbitSiteBaseUrl;
	}



	public String getApiBaseUrl() {
		return apiBaseUrl;
	}



	public void setApiBaseUrl(String apiBaseUrl) {
		this.apiBaseUrl = apiBaseUrl;
	}



	public String getExampleBaseUrl() {
		return exampleBaseUrl;
	}



	public void setExampleBaseUrl(String exampleBaseUrl) {
		this.exampleBaseUrl = exampleBaseUrl;
	}



	public String getClientConsumerKey() {
		return clientConsumerKey;
	}



	public void setClientConsumerKey(String clientConsumerKey) {
		this.clientConsumerKey = clientConsumerKey;
	}



	public String getClientSecret() {
		return clientSecret;
	}



	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}




}
