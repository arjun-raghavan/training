import Vue from 'vue'
import VueRouter from 'vue-router'
// import Home from '../views/Home'
import About from '../views/About'
import User from '../components/user/User'
import Details from '../components/Details'
import Overview from '../components/Overview'
import Others from "../components/Others"

Vue.use(VueRouter)

const router = new VueRouter({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'home', // Be sure to set 'name' property for the route you want to be "parent" route
      component: Overview,
      meta: {
        breadcrumb: 'Home Custom Label' // This is a shorthand for case you want to set just breadcrumb label
      }
    },
    {
      path: '/about',
      name: 'about',
      component: About,
      meta: {
        breadcrumb: {
          label: 'Custom About page Label',
          parent: 'home' // Here you should use exact string as for name property in "parent" route
        }
      }
    },
    {
      path: '/user',
      name: 'user',
      component: User,
      meta: {
        breadcrumb: {
          label: 'Custom About page Label',
          parent: 'home' // Here you should use exact string as for name property in "parent" route
        }
      }
    },
    {
      path: '/details',
      name: 'details',
      component: Details,
      meta: {
        breadcrumb: {
          label: 'Custom About page Label',
          parent: 'home' // Here you should use exact string as for name property in "parent" route
        }
      }
    },
    {
      path: '/overview',
      name: 'overview',
      component: Overview,
      meta: {
        breadcrumb: {
          label: 'Custom About page Label',
          parent: 'home' // Here you should use exact string as for name property in "parent" route
        }
      },
    },
    {
      path: '/Others',
      name: 'others',
      component: Others,

    }
  ]
})

export default router
