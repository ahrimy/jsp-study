package oliveYoung;

import java.util.ArrayList;
import java.util.HashMap;

public class StoreManager {
	HashMap<String, ArrayList<Store>> storeList = new HashMap<>();
	static StoreManager instance = new StoreManager();
	Store currentStore = null;

	public String saveStoreList() {
		String data = "";
		for (String key : storeList.keySet()) {
			for (int i = 0; i < storeList.get(key).size(); i++) {
				data += storeList.get(key).get(i).saveStore();
			}
		}
		data.substring(0, data.length() - 1);
		return data;
	}

	public void printAll() {
		for (String key : storeList.keySet()) {
			for (int i = 0; i < storeList.get(key).size(); i++) {
				storeList.get(key).get(i).print();
			}
		}
	}

	public void loadStoreList(String data) {
		String info[] = data.split("_");
		if (info.length == 5) {
			Store temp = new Store(info[0], info[1], Integer.parseInt(info[2]), Integer.parseInt(info[3]), info[4]);
			setCity(info[0], temp);
			currentStore = temp;
		} else {
			currentStore.loadStore(data);
		}
	}

	public void setCity(String city, Store store) {
		int check = 0;
		// �̹� �����ϴ� ī�װ���
		for (String key : storeList.keySet()) {
			if (key.equals(city)) {
				check = 1;
			}
		}
		// �������� �ʴ� ī�װ��� �߰�
		if (check == 0) {
			storeList.put(city, new ArrayList<Store>());
		}
		addStore(city, store);
	}

	public void addStore(String city, Store store) {
		int check = storeIndex(city, store);
		if (check == -1) {
			// �������� �ʴ� ����
			storeList.get(city).add(store);
		}
	}

	public String findStore(String city, String street, int code) {
		String storeName = "";
		if (storeList.get(city) != null) {
			for (int i = 0; i < storeList.get(city).size(); i++) {
				if (storeList.get(city).get(i).getStreet().equals(street)
						&& storeList.get(city).get(i).getStartCode() <= code
						&& storeList.get(city).get(i).getLastCode() >= code) {
					storeName = storeList.get(city).get(i).getStoreName();
					break;
				}
			}
		}
		return storeName;
	}

	public int storeIndex(String city, Store store) {
		int check = -1;
		for (int i = 0; i < storeList.get(city).size(); i++) {
			if (storeList.get(city).get(i).getStoreName().equals(store.getStoreName())) {
				check = i;
			}
		}
		return check;
	}
}