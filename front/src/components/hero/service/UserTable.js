import axios from '../service/callerService';
import React,{useState,useEffect} from "react";
import Modal from "react-modal";
import Button from "@mui/material/Button";
import TextField from "@mui/material/TextField";
import TableContainer from "@mui/material/TableContainer";
import Table from "@mui/material/Table";
import TableHead from "@mui/material/TableHead";
import TableBody from "@mui/material/TableBody";
import TableRow from "@mui/material/TableRow";
import TableCell from "@mui/material/TableCell";
import Paper from "@mui/material/Paper";

Modal.setAppElement('#root');

export default function UserTable() {
    const [users, setUsers] = useState([]);
    const [modalIsOpen, setModalIsOpen] = useState(false);
    const [userFirstname, setUserFirstname] = useState('');
    const [userLastname, setUserLastname] = useState('');
    const [userEmail, setUserEmail] = useState('');
    const [userUsername, setUserUsername] = useState('');
    const [userRole, setUserRole] = useState('');
    const [userPassword, setUserPassword] = useState('');
    const [userTel, setUserTel] = useState('');
    const [selectedUser, setSelectedUser] = useState(null);

    useEffect(() => {
        loadUsers();
    }, []);

    const loadUsers = async () => {
        const response = await axios.get("http://localhost:8080/api/users/");
        setUsers(response.data);
    };

    const handleDelete = async (id) => {
        if (window.confirm("Are you sure you want to delete this User?")) {
            await axios.delete(`http://localhost:8080/api/users/${id}`);
            setUsers(users.filter(user => user.id !== id));
        }
    };

    const handleOpenModal = (user) => {
        setSelectedUser(user);
        setModalIsOpen(true);
    };

    const handleCloseModal = () => {
        setModalIsOpen(false);
    };

    const handleEditUser = async (id) => {
        try {
            const response = await axios.put(`http://localhost:8080/api/users/${id}`, {
                firstName: userFirstname,
                lastName: userLastname,
                email: userEmail,
                username: userUsername,
                password: userPassword,
                role: userRole,
                telephone: userTel,
            });
            const updatedUser = users.map(user => (user.id === id ? response.data : user));
            setUsers(updatedUser);
            setModalIsOpen(false);
            loadUsers();
        } catch (error) {
            console.error(error);
        }
    };

    return (
        <div>
            <TableContainer component={Paper}>
                <Table sx={{ minWidth: 650 }} aria-label="user table">
                    <TableHead>
                        <TableRow>
                            <TableCell>ID</TableCell>
                            <TableCell>Firstname</TableCell>
                            <TableCell>Lastname</TableCell>
                            <TableCell>Username</TableCell>
                            <TableCell>Role</TableCell>
                            <TableCell>Email</TableCell>
                            <TableCell>Telephone</TableCell>
                            <TableCell>Action</TableCell>
                        </TableRow>
                    </TableHead>
                    <TableBody>
                        {users.map(user => (
                            <TableRow key={user.id}>
                                <TableCell>{user.id}</TableCell>
                                <TableCell>{user.firstName}</TableCell>
                                <TableCell>{user.lastName}</TableCell>
                                <TableCell>{user.username}</TableCell>
                                <TableCell>{user.role}</TableCell>
                                <TableCell>{user.email}</TableCell>
                                <TableCell>{user.telephone}</TableCell>
                                <TableCell>
                                    <Button variant="contained" color="error" onClick={() => handleDelete(user.id)}>Delete</Button>
                                    <Button variant="contained" color="primary" onClick={() => handleOpenModal(user)}>Edit</Button>
                                </TableCell>
                            </TableRow>
                        ))}
                    </TableBody>
                </Table>
            </TableContainer>

            <Modal
                isOpen={modalIsOpen}
                onRequestClose={handleCloseModal}
                style={{
                    overlay: {
                        backgroundColor: 'rgba(0, 0, 0, 0.5)',
                        zIndex: 999
                    },
                    content: {
                        top: '50%',
                        left: '50%',
                        right: 'auto',
                        bottom: 'auto',
                        marginRight: '-50%',
                        transform: 'translate(-50%, -50%)',
                        backgroundColor: '#fff',
                        borderRadius: '10px',
                        boxShadow: '20px 30px 25px rgba(0, 0, 0, 0.2)',
                        padding: '20px',
                        width: '100%',
                        maxWidth: '700px',
                        height: 'auto',
                        maxHeight: '90%',
                        overflow: 'auto'
                    }
                }}
            >
                <div>
                    <h5>Update User</h5>
                    <form>
                        <TextField
                            label="Firstname"
                            value={userFirstname}
                            onChange={(e) => setUserFirstname(e.target.value)}
                            fullWidth
                            margin="normal"
                        />
                        <TextField
                            label="Lastname"
                            value={userLastname}
                            onChange={(e) => setUserLastname(e.target.value)}
                            fullWidth
                            margin="normal"
                        />
                        <TextField
                            label="Email"
                            value={userEmail}
                            onChange={(e) => setUserEmail(e.target.value)}
                            fullWidth
                            margin="normal"
                        />
                        <TextField
                            label="Username"
                            value={userUsername}
                            onChange={(e) => setUserUsername(e.target.value)}
                            fullWidth
                            margin="normal"
                        />
                        <TextField
                            label="Password"
                            value={userPassword}
                            onChange={(e) => setUserPassword(e.target.value)}
                            fullWidth
                            margin="normal"
                        />
                        <TextField
                            label="Role"
                            value={userRole}
                            onChange={(e) => setUserRole(e.target.value)}
                            fullWidth
                            margin="normal"
                        />
                        <TextField
                            label="Telephone"
                            value={userTel}
                            onChange={(e) => setUserTel(e.target.value)}
                            fullWidth
                            margin="normal"
                        />
                        <div className="d-flex justify-content-center mt-3">
                            <Button variant="contained" onClick={handleCloseModal}>Cancel</Button>
                            <Button variant="contained" onClick={() => handleEditUser(selectedUser.id)}>Save</Button>
                        </div>
                    </form>
                </div>
            </Modal>
        </div>
    );
}
