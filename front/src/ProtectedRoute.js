import React from 'react';
import { Routes, Route, Navigate } from 'react-router-dom';
import AdminRoute from './Auth/AdminRoute';

const ProtectedRoute = () => {
    const isLogged = () => {
        // Vérifiez si l'utilisateur est authentifié
        // Retourne true ou false en fonction de l'état de l'authentification
    };

    return isLogged() ? (
        <AdminRoute />
    ) : (
        <Navigate to="/" />
    );
};

export default ProtectedRoute;
