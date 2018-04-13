/**
 * 
 */
package persistance;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.index.reindex.BulkByScrollResponse;
import org.elasticsearch.index.reindex.UpdateByQueryAction;
import org.elasticsearch.index.reindex.UpdateByQueryRequestBuilder;

import com.example.jetty_jersey.ws.User;
import com.example.jetty_jersey.ws.User.UserClass;

/**
 * @author Valentin
 *
 */
public class UserDB implements UserDAO {

	/* (non-Javadoc)
	 * @see persistance.UserDAO#getUser(java.lang.String)
	 */
	public static void authoriseModifUser(){
		TransportClient client = Bdd.connectionToBD();
		UpdateByQueryRequestBuilder updateByQuery = UpdateByQueryAction.INSTANCE.newRequestBuilder(client);
		updateByQuery.source("user").abortOnVersionConflict(false);
		BulkByScrollResponse response = updateByQuery.get();
	}
	public UserClass getUser(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see persistance.UserDAO#addUser(com.example.jetty_jersey.ws.User)
	 */
	public UserClass addUser(UserClass instance) {
		UserClass inst =  instance;
		TransportClient client = Bdd.connectionToBD();
		UserDB.authoriseModifUser();
		Map<String, Object> json = new HashMap<String, Object>();
		IndexResponse response = null;
		try {
			response = client.prepareIndex("user","name")
			        .setSource(jsonBuilder()
			                    .startObject()
			                        .field("login", inst.login)
			                        .field("password", inst.password)
			                    .endObject()
			                  )
			        .get();
		} catch (IOException e) {
			
		}
		return inst;
	}

	/**
	 * Edit un utilisateur
	 * TODO : tester edituser
	 */
	public void editUser(int id, UserClass instance) {
		TransportClient client = Bdd.connectionToBD();
		UpdateRequest updateRequest = new UpdateRequest();
		updateRequest.index("user");
		updateRequest.type("name");
		updateRequest.id(id+"");
		try {
			updateRequest.doc(jsonBuilder()
			        .startObject()
			            .field("login", instance.login)
						.field("password", instance.password)
			        .endObject());
			client.update(updateRequest).get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/* (non-Javadoc)
	 * @see persistance.UserDAO#deleteUser(com.example.jetty_jersey.ws.User)
	 */
	public void deleteUser(UserClass instance) {
		

	}

}
