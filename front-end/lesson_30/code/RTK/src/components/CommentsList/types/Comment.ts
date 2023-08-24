export default interface Comment {
	id: number;
	body: string;
	postId: number;
	user: {
		id: number;
		username: string;
	};
}
