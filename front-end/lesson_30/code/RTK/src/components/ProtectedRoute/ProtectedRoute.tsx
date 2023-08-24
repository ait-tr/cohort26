import { Navigate } from 'react-router-dom';
import { useAppSelector } from '../../app/hooks';
import { selectUser } from '../../features/auth/selectors';

interface Props {
	outlet: JSX.Element;
}

export default function ProtectedRoute({ outlet }: Props): JSX.Element {
	const user = useAppSelector(selectUser); // получили user или undefined
	if (user) {
		return outlet;
	}
	return <Navigate to="../login" />; // компонент, который делает редирект
}
