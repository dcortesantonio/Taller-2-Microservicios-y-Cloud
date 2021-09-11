import instance from '../api/jersey';
import CreateDataContext from './CreateDataContext';

const PaseoReducer = (state, action) => {
	switch (action.type) {
		case 'getAll':
			return {...state, paseos: action.data};
		case 'deletePaseo':
			return {...state, paseo: action.data};
		case 'updatePaseo':
			return {...state, paseo: action.data};
		case 'createPaseo':
			return {...state, paseo: action.data};
		default:
			return {...state, errorMessage: ''};

	}
};

const getAll = (dispatch) => async() => {
	try{
		const response = await instance.get();
		const resPas = response.data
		dispatch({type: 'getAll', data: resPas})
	}catch(err){
        console.log("Llego al catch: ", err.message)
		dispatch({type: 'add_error', data: err.message});
	}
}

const deletePaseo = (dispatch) => async({idPaseo}) => {
	try{
        console.log("En Context", idPaseo);
		const response = await instance.delete(`${idPaseo}`);
		dispatch({type: 'deletePaseo', data: response.data})
	}catch(err){
		dispatch({type: 'add_error', data: err.message});
	}
}

const updatePaseo = (dispatch) => async({idPaseo, paseoOrigin, paseoDest}) => {
	try{
        console.log("Update", idPaseo);
		const response = await instance.put(`${idPaseo}`, null, {params:{
			paseoOrigin, 
			paseoDest
		}});
		dispatch({type: 'updatePaseo', data: response.data})
	}catch(err){
		dispatch({type: 'add_error', data: err.message});
	}
}

const createPaseo = (dispatch) => async({
	idPaseo, 
	paseoOrigin, 
	paseoDest,
	namePaseo}) => {
	try{
		const response = await instance.post('', {
			"name": namePaseo,
			"origin":paseoOrigin, 
			"destination":paseoDest,
			"id": idPaseo
		});
		dispatch({type: 'createPaseo', data: response.data})
	}catch(err){
		dispatch({type: 'add_error', data: err.message});
	}
}

export const { Provider, Context } = CreateDataContext(
	PaseoReducer,
	{getAll, deletePaseo, updatePaseo, createPaseo},
	{errorMessage: '', paseos: [], paseo:''}
)
