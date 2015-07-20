package BAFitbit.BAFitbitClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.joda.time.LocalDate;

import com.fitbit.api.FitbitAPIException;
import com.fitbit.api.client.FitbitApiClientAgent;
import com.fitbit.api.client.LocalUserDetail;
import com.fitbit.api.client.http.AccessToken;
import com.fitbit.api.client.http.TempCredentials;
import com.fitbit.api.client.service.FitbitAPIClientService;
import com.fitbit.api.common.model.sleep.Sleep;
import com.fitbit.api.common.model.timeseries.Data;
import com.fitbit.api.common.model.timeseries.TimeSeriesResourceType;
import com.fitbit.api.model.APIResourceCredentials;
import com.fitbit.api.model.FitbitUser;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		TestFitbitClient testClient = new TestFitbitClient();
		FitbitAPIClientService<FitbitApiClientAgent> testIni;
		testIni = testClient.initalize();
		FitbitApiClientAgent client = testIni.getClient();
		try {
			TempCredentials tempCredentials = client.getOAuthTempToken();
			System.out.println("Call: "+ tempCredentials.getAuthorizationURL());
			String pin = readLine();

			AccessToken accessToken = client.getOAuthAccessToken(tempCredentials, pin);
			APIResourceCredentials apiResCred = new APIResourceCredentials("Foo", tempCredentials.getToken(), tempCredentials.getTokenSecret());
	        apiResCred.setAccessToken(accessToken.getToken());
	        apiResCred.setAccessTokenSecret(accessToken.getTokenSecret());
	        apiResCred.setResourceId(accessToken.getEncodedUserId());
	        LocalUserDetail localUser = new LocalUserDetail("Foo");
	        client.getCredentialsCache().saveResourceCredentials(localUser, apiResCred);
	        LocalDate localDate = new LocalDate(2015, 07, 18);
//	        System.out.println(localDate.toString());
	        FitbitUser fitbitUser = FitbitUser.CURRENT_AUTHORIZED_USER;
//	        Sleep sleep = client.getSleep(localUser, fitbitUser, localDate);
	        List<Data> foo = client.getTimeSeries(fitbitUser, TimeSeriesResourceType.DISTANCE, localDate, localDate);
//	        System.out.println(sleep.getSummary().getTotalMinutesAsleep());
	        System.out.println(foo.toString());
		} catch (FitbitAPIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// try {
		// System.out.println(testIni.getClientRateLimitStatus().getRemainingHits());
		// } catch (FitbitAPIException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
	}

	private static String readLine() {
		String string = "";
		try {
			InputStreamReader converter = new InputStreamReader(System.in);
			BufferedReader in = new BufferedReader(converter);
			string = in.readLine();
		} catch (Exception e) {
			System.out.println("Error! Exception: " + e);
		}
		return string;
	}

	
}
