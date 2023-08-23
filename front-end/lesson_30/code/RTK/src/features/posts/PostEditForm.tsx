import { FormEvent, useState } from 'react';
import { useAppDispatch } from '../../app/hooks';
import { editTitle } from './postsSlice';

export default function PostEditForm(props: { postId: number }): JSX.Element {
	const { postId } = props;
	const [title, setTitle] = useState<string>('');
	const dispatch = useAppDispatch();
	function handleSubmit(e: FormEvent<HTMLFormElement>): void {
		e.preventDefault();
		dispatch(editTitle({ id: postId, title }));
	}
	return (
		<div>
			<form onSubmit={handleSubmit}>
				<input
					type="text"
					placeholder="new title"
					value={title}
					onChange={(e) => setTitle(e.target.value)}
				/>
				<button type="submit">edit</button>
			</form>
		</div>
	);
}
