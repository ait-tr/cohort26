import TaskCredentials from './TaskCredentials';

type Action =
  | { type: 'tasks/add', payload: TaskCredentials }
  | { type: 'tasks/changeStatus', payload: string } // id -это стринг в данном случае
  | { type: 'tasks/remove', payload: string };

export default Action;
