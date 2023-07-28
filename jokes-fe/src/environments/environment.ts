export const environment = {
  production: true,
  //inject baseurl from kubernetes configmap
  baseUrl: window['env']['apiUrl']
};
