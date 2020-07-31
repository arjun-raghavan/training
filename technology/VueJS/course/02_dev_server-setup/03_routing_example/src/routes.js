import User from "./components/user/User.vue"
import UserStart from "./components/user/UserStart.vue"
import UserDetail from "./components/user/UserDetail.vue"
import UserEdit from "./components/user/UserEdit.vue"
import Home from "./components/Home.vue";

export const routes = [
  // {path: '/user/:id', component: User},
  {path: '/user', component: User, children: [
    {path: "", components: UserStart},
    {path: ":id", components: UserDetail},
    {path: ":id/edit", components: UserEdit}
  ]},
  {path: '', component: Home}
]