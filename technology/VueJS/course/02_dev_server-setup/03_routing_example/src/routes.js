import Home from './components/Home.vue';
import Header from './components/Header.vue';
import Profile from "./components/Profile.vue";

const User = resolve => {
    require.ensure(['./components/user/User.vue'], () => {
        resolve(require('./components/user/User.vue'));
    }, 'user');
};
//the last param 'user' is the group. this will group into single bundle. else different bundle is created.
const UserStart = resolve => {
    require.ensure(['./components/user/UserStart.vue'], () => {
        resolve(require('./components/user/UserStart.vue'));
    }, 'user');
};
const UserEdit = resolve => {
    require.ensure(['./components/user/UserEdit.vue'], () => {
        resolve(require('./components/user/UserEdit.vue'));
    }, 'user');
};
const UserDetail = resolve => {
    require.ensure(['./components/user/UserDetail.vue'], () => {
        resolve(require('./components/user/UserDetail.vue'));
    }, 'user');
};



export const routes = [
  // {path: '/user/:id', component: User},
  {
    path: '/user', 
    components: {
      default: User,
      'header-bottom': Header},
    children: [
      {path: "", component: UserStart},
      {
        path: ":id", 
        component: UserDetail, 
        beforeEnter: (to, from, next) => {
          console.log('inside route setup');
          next();
        }
      },
      {path: ":id/edit", component: UserEdit, name: 'userEdit'}
  ]},
  {
    path: '', 
    name: 'home', 
    components: {
      default: Home,
      'header-top': Header
    }},
  {path: '/profile', component: Profile},
  {path: '/redirect-me', redirect: '/user'},
  {path: '*', redirect: '/'}
]