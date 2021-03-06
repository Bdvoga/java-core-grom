package lesson9.Ex6UserRepository;

public class UserRepository {
    private User[] users;

    public UserRepository(User[] users) {
        this.users = users;
    }

    public User[] getUsers() {
        return users;
    }

    public void setUsers(User[] users) {
        this.users = users;
    }

    // save
    public User save(User user) {
        if (findById(user.getId()) != null) {
            return null;
        }

        for (int i = 0; i < getUsers().length; i++) {
            if (getUsers()[i] == null) {
                getUsers()[i] = user;
                return getUsers()[i];
            }
        }
        return null;
    }

    // update
    public User update(User user) {
        if (findById(user.getId()) == null) {
            return null;
        }

        // если есть, обновляем и возвращаем.
        for (int i =0; i < getUsers().length; i++) {
            if (getUsers()[i].getId() == user.getId()) {
                getUsers()[i] = user;

                return getUsers()[i];
            }
        }
        return null;
    }

    // delete
    public void delete(long id) {
        for (int i = 0; i < getUsers().length; i++) {
            if (getUsers()[i] == null) {
                break;
            }
            if (getUsers()[i].getId() == id) {
                getUsers()[i] = null;
                return;
            }
        }
    }

    public User findById(long id) {
        for (User el : users) {
            if (el == null) {
                return null;
            }
            if (el.getId() == id)
                return el;
        }
        return null;
    }
}