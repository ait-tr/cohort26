interface Address {
  city: string,
  street: string,
  number: number,
  zipcode: string,
  geolocation: {
    lat: string,
    long: string
  }
}

export default interface User {
  id: number,
  email: string,
  username: string,
  password: string,
  name: {
    firstname: string,
    lastname: string
  },
  address: Address,
  phone: string
}
