package persistance;

import com.example.jetty_jersey.ws.ListTag;

interface ListTagDAO {
	ListTag getListTag();
	void addListTag(ListTag instance);
	void editListTag(int id, ListTag instance);
	void deleteListTag(ListTag instance);
}
