
import { useEffect, useState } from "react";
import "./App.css";

const API_URL = "/api/users";

function App() {
  const [users, setUsers] = useState([]);
  const [form, setForm] = useState({
    name: "",
    email: "",
  });

  const [loading, setLoading] = useState(false);
  const [error, setError] = useState("");

  // GET: Lấy danh sách user từ backend
  const fetchUsers = async () => {
    try {
      const response = await fetch(API_URL);

      if (!response.ok) {
        throw new Error("Cannot fetch users");
      }

      const data = await response.json();
      setUsers(data);
    } catch (error) {
      setError(error.message);
    }
  };

  // Tự động lấy user khi component được render lần đầu
  useEffect(() => {
    fetchUsers();
  }, []);

  // Cập nhật dữ liệu form
  const handleChange = (event) => {
    const { name, value } = event.target;

    setForm((prev) => ({
      ...prev,
      [name]: value,
    }));
  };

  // POST: Thêm user vào database
  const handleSubmit = async (event) => {
    event.preventDefault();

    setLoading(true);
    setError("");

    try {
      const response = await fetch(API_URL, {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({
          ...form,
        }),
      });

      if (!response.ok) {
        throw new Error("Failed to create user");
      }

      // Reset form
      setForm({
        name: "",
        email: "",
      });

      // Lấy lại danh sách user sau khi tạo
      await fetchUsers();

    } catch (error) {
      setError(error.message);
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="container">
      <h1>User Management</h1>

      <form onSubmit={handleSubmit} className="user-form">
        <h2>Add New User</h2>

        <input
          type="text"
          name="name"
          placeholder="Full Name"
          value={form.name}
          onChange={handleChange}
          required
        />

        <input
          type="email"
          name="email"
          placeholder="Email"
          value={form.email}
          onChange={handleChange}
          required
        />

        <button type="submit" disabled={loading}>
          {loading ? "Saving..." : "Add User"}
        </button>
      </form>

      {error && <p className="error">{error}</p>}

      <h2>Users List</h2>

      <button onClick={fetchUsers}>
        Refresh Users
      </button>

      <table>
        <thead>
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Age</th>
          </tr>
        </thead>

        <tbody>
          {users.map((user) => (
            <tr key={user.id}>
              <td>{user.id}</td>
              <td>{user.name}</td>
              <td>{user.email}</td>
              <td>{user.age}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default App;
