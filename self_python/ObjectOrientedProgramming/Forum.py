class ForumUser():
    def __init__(self, Nick="annon"):
        if Nick == "":
            self._Nick = "annon"
        else:
            self._Nick = Nick.lower()
        self._messages_amm = 0
        self._is_banned = False

    @property
    def Nick(self):
        return self._Nick

    @property
    def messages_amm(self):
        return self._messages_amm

    @property
    def is_banned(self):
        return self._is_banned

    @is_banned.setter
    def is_banned(self, bool_ban):
        self._is_banned = bool_ban

    def ban(self, other_user):
        if self._messages_amm >= 10000:
            print("I am expert user I can ban")
            other_user.is_banned = not other_user.is_banned
        else:
            print("I am regular user")

    def __repr__(self):
        return f"ForumUser {self._Nick}, messages {self._messages_amm}, ban status {self._is_banned}"

    @messages_amm.setter
    def messages_amm(self, value):
        self._messages_amm = value


class Admin(ForumUser):
    """15. Write an Admin class derived from ForumUser. The administrator can write messages regardless of the ban. The administrator's nick must start with the letter 'A'."""
    def __init__(self, Nick):
        super().__init__(Nick=f"A{Nick}")

    def ban(self, other_user):
        print("I am admin")
        other_user.is_banned = not other_user.is_banned


if __name__ == "__main__":
    pr = ForumUser("prison")
    a = Admin("admin")
    b = ForumUser("B")
    b.messages_amm = 100000
    c = ForumUser("C")
    a.ban(pr)
    b.ban(pr)
    c.ban(pr)
