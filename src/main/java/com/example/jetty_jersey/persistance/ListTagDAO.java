package persistance;

import com.example.jetty_jersey.ws.ListTag.ListTagClass;;

interface ListTagDAO {
	ListTagClass getListTag();
	void addListTag(ListTagClass instance);
	void editListTag(int id, ListTagClass instance);
	void deleteListTag(ListTagClass instance);
}
