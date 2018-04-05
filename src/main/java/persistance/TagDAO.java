package persistance;

import com.example.jetty_jersey.ws.*;

interface TagDAO {
	Tag getTag();
	void addTag(Tag instance);
	void editTag(int id, Tag instance);
	void deleteTag(Tag instance);
}