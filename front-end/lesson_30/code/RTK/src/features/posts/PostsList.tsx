import { useEffect, useState } from 'react';
import { useAppDispatch, useAppSelector } from '../../app/hooks';
import { selectFiltered } from './selectors';
import { loadPostsByWord } from './postsSlice';
import styles from './PostsList.module.css';
import PostEditForm from './PostEditForm';
import CommentsList from '../../components/CommentsList/CommentsList';

export default function PostsList(): JSX.Element {
	const posts = useAppSelector(selectFiltered);
	const dispatch = useAppDispatch();
	const [word, setWord] = useState<string>('');
	useEffect(() => {
		dispatch(loadPostsByWord(word));
	}, [dispatch, word]);

	return (
		<div className={styles.container}>
			<h1 className={styles.heading}>Forum</h1>
			<div className={styles.inputContainer}>
				<input
					className={styles.searchWord}
					type="text"
					value={word}
					onChange={(e) => setWord(e.target.value)}
					placeholder="search by word"
				/>
			</div>
			<ul className={styles.list}>
				{posts.map((post) => (
					<li key={post.id} className={styles.post}>
						<p>
							<b>{post.title}</b>
						</p>
						<PostEditForm postId={post.id} />
						{post.body}
						<div className={styles.tagsContainer}>
							{post.tags.map((tag) => (
								<span key={tag} className={styles.tag}>
									{tag}
								</span>
							))}
						</div>
						<CommentsList postId={post.id} />
					</li>
				))}
			</ul>
		</div>
	);
}
