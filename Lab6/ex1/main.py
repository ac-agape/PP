class ContactList(list):
  def search(self, name):
    matching_contacts = []
    for contact in self:
      if name in contact.name:
        matching_contacts.append(contact)
    return matching_contacts

class Contact:
  def __init__(self, name, email): # constructor
    self.name = name
    self.email = email

# echivalentul supraincarcarii operator<< din c++
  def __repr__(self):
    return "Contact({}, {})".format(self.name, self.email)

class Agenda:
  all_contacts = ContactList()
  def add_contact(self, contact):
    self.all_contacts.append(contact)

  def print_agenda(self):
    for contact in self.all_contacts:
      print(contact)


class Friend(Contact):
  def __init__(self, name, email, phone, friendship_status):
    super().__init__(name, email)
    self.phone = phone
    self.friendship_status = friendship_status

  def friendship(self):
    print("Me and", self.name, 'are', self.friendship_status)

  def __repr__(self):
    return "Friend({}, {}, {}, {})".format(self.name, self.email, self.phone, self.friendship_status)



# acest bloc se executa doar cand se apeleaza acest script
# se recomanda folosirea acestui bloc pentru a nu se executa la import
if __name__ == '__main__':
  agenda = Agenda()
  frand = Friend('Pushi', 'agape.pushi18@meow.mice', '07NamCartela', 'friends with food benefits');
  frand.friendship();
  agenda.add_contact(Contact('Ion Popescu','ion_popescu@gmail.com'))
  agenda.add_contact(frand)
  agenda.print_agenda()


