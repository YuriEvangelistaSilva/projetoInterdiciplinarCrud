<!-- Sidebar -->
        <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

            <!-- Sidebar - Brand -->
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.html">
                <div class="sidebar-brand-icon rotate-n-15">
                    <i class="fas fa-laugh-wink"></i>
                </div>
                <div class="sidebar-brand-text mx-3">YK games</div>
            </a>

            <!-- Divider -->
            <hr class="sidebar-divider my-0">

            <!-- Nav Item - Dashboard -->
            <li  class="sidebar-heading">
                    <span>Bem vindo ADM</span></a>
            </li>

            <!-- Divider -->
            <hr class="sidebar-divider">

            <!-- Heading -->
            <div class="sidebar-heading">
                Interface
            </div>

            <!-- Nav Item - Pages Collapse Menu -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo"
                    aria-expanded="true" aria-controls="collapseTwo">
                    <i class="fas fa-fw fa-cog"></i>
                    <span>Cadastros</span>
                </a>
                <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">canpos de listagem de dados:</h6>
                <a href="${pageContext.request.contextPath}/PublicoListar" class="collapse-item">publico</a>
                <a href="${pageContext.request.contextPath}/GeneroListar" class="collapse-item">Genero</a>
                <a href="${pageContext.request.contextPath}/GameListar" class="collapse-item">Games</a>
                <a href="${pageContext.request.contextPath}/CatalogoListar" class="collapse-item">Catalogo</a>
                <a href="${pageContext.request.contextPath}/ContaListar" class="collapse-item">Conta</a>
                <a href="${pageContext.request.contextPath}/PlataformaListar" class="collapse-item">plataforma</a>
                    </div>
                </div>
            </li>

            
            

            

            

            

           
            <!-- Divider -->
            <hr class="sidebar-divider d-none d-md-block">

            <!-- Sidebar Toggler (Sidebar) -->
            <div class="text-center d-none d-md-inline">
                <button class="rounded-circle border-0" id="sidebarToggle"></button>
            </div>

            

        </ul>
        <!-- End of Sidebar -->