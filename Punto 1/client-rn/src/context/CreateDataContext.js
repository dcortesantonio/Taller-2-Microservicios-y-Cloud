import React, { useReducer } from 'react';
//Esto es basicamente un template para los contextos.
//Ventaja: No hay tanto codigo repetido
//         Los demas contextos solo necesitan la lista de accines y el reducer.
//Desventajas: Hay mas WTFs por linea de codigo. 

export default (reducer, actions, initialState) => {
	const Context = React.createContext();

	const Provider = ({ children }) => {
		const [state, dispatch] = useReducer(reducer, initialState);

		const boundActions = {}; //coleccion de acciones que usan dispatch
		for (let key in actions) {
			//cada accion en la lista actions es llamada con dispatch.
			//Luego se asigna a una casilla en boundActions 
			boundActions[key] = actions[key](dispatch);
		}

		return <Context.Provider value={{ state, ...boundActions }}>{children}</Context.Provider>;
	};
	return { Context, Provider };
};
