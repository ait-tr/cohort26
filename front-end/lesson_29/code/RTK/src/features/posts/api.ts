import Post from './types/Post';

export async function getAll(): Promise<{ posts: Post[] }> {
	const res = await fetch('https://dummyjson.com/posts');
	return res.json();
}

export async function getPostsByWord(word: string): Promise<{ posts: Post[] }> {
	const res = await fetch(`https://dummyjson.com/posts/search?q=${word}`);
	return res.json();
}

export async function editPostTitle(title: string, id: number): Promise<Post> {
	const res = await fetch(`https://dummyjson.com/posts/${id}`, {
		method: 'PUT' /* or PATCH */,
		headers: { 'Content-Type': 'application/json' },
		body: JSON.stringify({
			title,
		}),
	});
	return res.json();
}
