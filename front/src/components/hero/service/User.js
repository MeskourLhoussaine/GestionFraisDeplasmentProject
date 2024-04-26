import React, { useState, useEffect, useReducer } from "react";
import axios from 'axios';
import Button from '@mui/material/Button';
import CssBaseline from '@mui/material/CssBaseline';
import TextField from '@mui/material/TextField';
import Grid from '@mui/material/Grid';
import Box from '@mui/material/Box';
import Typography from '@mui/material/Typography';
import Container from '@mui/material/Container';

import { createTheme, ThemeProvider } from '@mui/material/styles';
import UserTable from "./UserTable";

const theme = createTheme();

export default function User() {
    const [user, setUser] = useState([]);
    const [firstname, setFirstName] = useState("");
    const [lastname, setLastName] = useState("");
    const [email, setEmail] = useState("");
    const [username, setUserName] = useState("");
    const [telephone, settel] = useState("");
    const [password, setPassword] = useState("");
    const [roles, setRole] = useState("");
    const [upTB, forceUpdate] = useReducer((x) => x + 1, 0);
    const [tableKey, setTableKey] = useState(Date.now());

    useEffect(() => {
        axios.get("http://localhost:9090/api/users/").then((response) => {
            setUser(response.data);
        });
    }, [upTB]);

    const handleSubmit = (event) => {
        event.preventDefault();
        axios.post("http://localhost:9090/api/auth/signup", {
            firstname,
            lastname,
            username,
            roles,
            password,
            telephone
        })
        .then((response) => {
            setFirstName("");
            setLastName("");
            setUserName("");
            setPassword("");
            setRole("");
            forceUpdate();
            setTableKey(Date.now());
        })
        .catch((error) => {
            console.error(error);
        });
    };

    return (
        <ThemeProvider theme={theme}>
            <Container component="main" maxWidth="xs">
                <CssBaseline />
                <form onSubmit={handleSubmit}>
                    <Box
                        sx={{
                            marginTop: 8,
                            display: 'flex',
                            flexDirection: 'column',
                            alignItems: 'center',
                        }}
                    >
                        <Typography component="h1" variant="h5">
                            Users
                        </Typography>
                        <Grid container spacing={2}>
                            <Grid item xs={12} sm={6}>
                                <TextField
                                    required
                                    fullWidth
                                    label="First Name"
                                    autoComplete="given-name"
                                    value={firstname}
                                    onChange={(event) => setFirstName(event.target.value)}
                                />
                            </Grid>
                            <Grid item xs={12} sm={6}>
                                <TextField
                                    required
                                    fullWidth
                                    label="Last Name"
                                    autoComplete="family-name"
                                    value={lastname}
                                    onChange={(event) => setLastName(event.target.value)}
                                />
                            </Grid>
                            <Grid item xs={12}>
                                <TextField
                                    required
                                    fullWidth
                                    label="Email"
                                    autoComplete="email"
                                    value={email}
                                    onChange={(event) => setEmail(event.target.value)}
                                />
                            </Grid>
                            <Grid item xs={12}>
                                <TextField
                                    required
                                    fullWidth
                                    label="Username"
                                    autoComplete="username"
                                    value={username}
                                    onChange={(event) => setUserName(event.target.value)}
                                />
                            </Grid>
                            <Grid item xs={12}>
                                <TextField
                                    required
                                    fullWidth
                                    label="Role"
                                    autoComplete="role"
                                    value={roles}
                                    onChange={(event) => setRole(event.target.value)}
                                />
                            </Grid>
                            <Grid item xs={12}>
                                <TextField
                                    required
                                    fullWidth
                                    label="Password"
                                    type="password"
                                    autoComplete="new-password"
                                    value={password}
                                    onChange={(event) => setPassword(event.target.value)}
                                />
                            </Grid>
                        </Grid>
                        <Button
                            type="submit"
                            fullWidth
                            sx={{ mt: 3, mb: 2 }}
                            variant="contained"
                        >
                            Add
                        </Button>
                    </Box>
                </form>
            </Container>
            <UserTable key={tableKey}/>
        </ThemeProvider>
    );
}
