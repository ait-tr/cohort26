// eslint-disable-next-line import/default
import ReactDOM from 'react-dom/client';
import { Provider } from 'react-redux';
import { store } from './app/store';
import App from './App';
import './index.css';
// eslint-disable-next-line import/no-extraneous-dependencies
import { HashRouter } from 'react-router-dom';

ReactDOM.createRoot(document.getElementById('root')!).render(
	// <React.StrictMode>
	<HashRouter>
		<Provider store={store}>
			<App />
		</Provider>
	</HashRouter>
	// </React.StrictMode>,
);
