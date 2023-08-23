import { useEffect, useState } from 'react';
import Comment from './types/Comment';

export default function CommentsList(props: { postId: number }): JSX.Element {
	const { postId } = props;
	const [comments, setComments] = useState<Comment[]>([]);
	async function loadComments(): Promise<void> {
		const res = await fetch(`https://dummyjson.com/comments/post/${postId}`);
		const obj: { comments: Comment[] } = await res.json();
		setComments(obj.comments);
	}
	useEffect(() => {
		loadComments();
	}, []);
	return (
		<ul style={{ listStyleType: 'none' }}>
			{comments.map((comment) => (
				<li key={comment.id}>
					<b>{comment.user.username}</b> {comment.body}
				</li>
			))}
		</ul>
	);
}
